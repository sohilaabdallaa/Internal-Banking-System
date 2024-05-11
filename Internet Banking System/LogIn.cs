using System.Data.SqlClient;
using System.Text.RegularExpressions;


namespace OnlineMobileAPP
{
    public partial class LogIn : Form
    {
        string Email;
        string Password;
        public static int userID = 0;

        public LogIn()
        {

            InitializeComponent();
        }



        private bool validateUserPassword()
        {
            Email = textBox1.Text;
            Password = textBox2.Text;

            string connectionString = "Data Source=.;Initial Catalog=mobilestore_db;Integrated Security=True";
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                SqlCommand checkUserCommand = new SqlCommand("SELECT COUNT(*) FROM dbo.Users WHERE Email = @Email AND Password = @Password", connection);
                checkUserCommand.Parameters.AddWithValue("@Email", Email);
                checkUserCommand.Parameters.AddWithValue("@Password", Password);
                int userCount = (int)checkUserCommand.ExecuteScalar();

                return userCount > 0; // True if user exists with the given email and password
            }
        }

        private void NeedToJoin(object sender, EventArgs e)
        {
            SignUp join = new SignUp();
            join.Show();
        }
    }
}
