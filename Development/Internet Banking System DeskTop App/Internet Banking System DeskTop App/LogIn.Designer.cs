namespace Internet_Banking_System_DeskTop_App
{
    partial class LogIn
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            logout = new Button();
            tableLayoutPanel1 = new TableLayoutPanel();
            label1 = new Label();
            textBox1 = new TextBox();
            splitContainer1 = new SplitContainer();
            textBox2 = new TextBox();
            panel1 = new Panel();
            panel2 = new Panel();
            label2 = new Label();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            textBox5 = new TextBox();
            label3 = new Label();
            textBox6 = new TextBox();
            textBox7 = new TextBox();
            label4 = new Label();
            label5 = new Label();
            ((System.ComponentModel.ISupportInitialize)splitContainer1).BeginInit();
            splitContainer1.Panel1.SuspendLayout();
            splitContainer1.Panel2.SuspendLayout();
            splitContainer1.SuspendLayout();
            panel1.SuspendLayout();
            panel2.SuspendLayout();
            SuspendLayout();
            // 
            // logout
            // 
            logout.Location = new Point(772, 12);
            logout.Name = "logout";
            logout.Size = new Size(130, 40);
            logout.TabIndex = 3;
            logout.Text = "logout";
            logout.UseVisualStyleBackColor = true;
            // 
            // tableLayoutPanel1
            // 
            tableLayoutPanel1.ColumnCount = 2;
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 68.9516144F));
            tableLayoutPanel1.ColumnStyles.Add(new ColumnStyle(SizeType.Absolute, 20F));
            tableLayoutPanel1.Location = new Point(0, 0);
            tableLayoutPanel1.Name = "tableLayoutPanel1";
            tableLayoutPanel1.RowCount = 2;
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel1.RowStyles.Add(new RowStyle(SizeType.Absolute, 20F));
            tableLayoutPanel1.Size = new Size(200, 100);
            tableLayoutPanel1.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F);
            label1.Location = new Point(179, 12);
            label1.Name = "label1";
            label1.Size = new Size(170, 41);
            label1.TabIndex = 5;
            label1.Text = "User Profile";
            label1.TextAlign = ContentAlignment.TopCenter;
            // 
            // textBox1
            // 
            textBox1.Font = new Font("Segoe UI", 15F);
            textBox1.Location = new Point(44, 17);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(191, 41);
            textBox1.TabIndex = 1;
            textBox1.Text = "Account 1";
            textBox1.TextAlign = HorizontalAlignment.Center;
            textBox1.TextChanged += textBox1_TextChanged;
            // 
            // splitContainer1
            // 
            splitContainer1.Location = new Point(12, 67);
            splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel1
            // 
            splitContainer1.Panel1.Controls.Add(textBox2);
            splitContainer1.Panel1.Controls.Add(textBox1);
            splitContainer1.Panel1.Paint += splitContainer1_Panel1_Paint_1;
            // 
            // splitContainer1.Panel2
            // 
            splitContainer1.Panel2.Controls.Add(panel2);
            splitContainer1.Panel2.Controls.Add(panel1);
            splitContainer1.Panel2.Controls.Add(label1);
            splitContainer1.Size = new Size(890, 448);
            splitContainer1.SplitterDistance = 293;
            splitContainer1.TabIndex = 5;
            // 
            // textBox2
            // 
            textBox2.Font = new Font("Segoe UI", 15F);
            textBox2.Location = new Point(44, 96);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(191, 41);
            textBox2.TabIndex = 2;
            textBox2.Text = "Account 2";
            textBox2.TextAlign = HorizontalAlignment.Center;
            // 
            // panel1
            // 
            panel1.Controls.Add(label5);
            panel1.Controls.Add(label4);
            panel1.Controls.Add(textBox7);
            panel1.Controls.Add(textBox6);
            panel1.Controls.Add(label3);
            panel1.Controls.Add(textBox5);
            panel1.Font = new Font("Segoe UI", 20F);
            panel1.Location = new Point(27, 72);
            panel1.Name = "panel1";
            panel1.Size = new Size(539, 252);
            panel1.TabIndex = 6;
            // 
            // panel2
            // 
            panel2.Controls.Add(textBox4);
            panel2.Controls.Add(textBox3);
            panel2.Controls.Add(label2);
            panel2.Location = new Point(27, 344);
            panel2.Name = "panel2";
            panel2.Size = new Size(539, 91);
            panel2.TabIndex = 7;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 10F);
            label2.Location = new Point(35, 11);
            label2.Name = "label2";
            label2.Size = new Size(168, 23);
            label2.TabIndex = 8;
            label2.Text = "Account Information";
            label2.TextAlign = ContentAlignment.TopCenter;
            label2.Click += label2_Click;
            // 
            // textBox3
            // 
            textBox3.Font = new Font("Segoe UI", 10F);
            textBox3.Location = new Point(25, 47);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(191, 30);
            textBox3.TabIndex = 3;
            textBox3.Text = "View Balance";
            textBox3.TextAlign = HorizontalAlignment.Center;
            // 
            // textBox4
            // 
            textBox4.Font = new Font("Segoe UI", 10F);
            textBox4.Location = new Point(281, 47);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(191, 30);
            textBox4.TabIndex = 9;
            textBox4.Text = "Transaction History";
            textBox4.TextAlign = HorizontalAlignment.Center;
            // 
            // textBox5
            // 
            textBox5.Font = new Font("Segoe UI", 10F);
            textBox5.Location = new Point(12, 217);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(191, 30);
            textBox5.TabIndex = 10;
            textBox5.Text = "Transfer";
            textBox5.TextAlign = HorizontalAlignment.Center;
            textBox5.TextChanged += textBox5_TextChanged;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 15F);
            label3.Location = new Point(12, 9);
            label3.Name = "label3";
            label3.Size = new Size(165, 35);
            label3.TabIndex = 11;
            label3.Text = "Fund Transfer";
            label3.Click += label3_Click;
            // 
            // textBox6
            // 
            textBox6.Font = new Font("Segoe UI", 9F);
            textBox6.Location = new Point(12, 166);
            textBox6.Name = "textBox6";
            textBox6.Size = new Size(336, 27);
            textBox6.TabIndex = 12;
            // 
            // textBox7
            // 
            textBox7.Font = new Font("Segoe UI", 9F);
            textBox7.Location = new Point(12, 89);
            textBox7.Name = "textBox7";
            textBox7.Size = new Size(336, 27);
            textBox7.TabIndex = 13;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 10F);
            label4.Location = new Point(12, 140);
            label4.Name = "label4";
            label4.Size = new Size(72, 23);
            label4.TabIndex = 14;
            label4.Text = "Amount";
            label4.Click += label4_Click;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 10F);
            label5.Location = new Point(12, 63);
            label5.Name = "label5";
            label5.Size = new Size(97, 23);
            label5.TabIndex = 15;
            label5.Text = "Destination";
            // 
            // LogIn
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(914, 600);
            Controls.Add(splitContainer1);
            Controls.Add(logout);
            Margin = new Padding(3, 4, 3, 4);
            Name = "LogIn";
            Text = "Form1";
            splitContainer1.Panel1.ResumeLayout(false);
            splitContainer1.Panel1.PerformLayout();
            splitContainer1.Panel2.ResumeLayout(false);
            splitContainer1.Panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)splitContainer1).EndInit();
            splitContainer1.ResumeLayout(false);
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            panel2.ResumeLayout(false);
            panel2.PerformLayout();
            ResumeLayout(false);
        }

        #endregion
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private Button logout;
        private TableLayoutPanel tableLayoutPanel1;
        private Label label1;
        private TextBox textBox1;
        private SplitContainer splitContainer1;
        private TextBox textBox2;
        private Panel panel1;
        private Panel panel2;
        private Label label2;
        private TextBox textBox4;
        private TextBox textBox3;
        private TextBox textBox5;
        private Label label3;
        private TextBox textBox6;
        private TextBox textBox7;
        private Label label4;
        private Label label5;
    }
}
