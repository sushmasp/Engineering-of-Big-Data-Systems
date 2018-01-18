namespace UserInputTest
{
    partial class UserInput
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.MonthCmbBx = new System.Windows.Forms.ComboBox();
            this.CrimeTypeCmbBx = new System.Windows.Forms.ComboBox();
            this.button1 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // MonthCmbBx
            // 
            this.MonthCmbBx.FormattingEnabled = true;
            this.MonthCmbBx.Items.AddRange(new object[] {
            "Select",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"});
            this.MonthCmbBx.Location = new System.Drawing.Point(194, 48);
            this.MonthCmbBx.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.MonthCmbBx.Name = "MonthCmbBx";
            this.MonthCmbBx.Size = new System.Drawing.Size(180, 28);
            this.MonthCmbBx.TabIndex = 0;
            this.MonthCmbBx.Text = "Select";
            // 
            // CrimeTypeCmbBx
            // 
            this.CrimeTypeCmbBx.AutoCompleteCustomSource.AddRange(new string[] {
            "Black",
            "White",
            "Others"});
            this.CrimeTypeCmbBx.FormattingEnabled = true;
            this.CrimeTypeCmbBx.Items.AddRange(new object[] {
            "Select",
            "Burglary",
            "Crime Sexual Assault",
            "Crime Damage",
            "Crime Tresspass",
            "Deceptive Practice",
            "Homicide",
            "Motor Vehicle Theft",
            "Narcotics",
            "Non Criminal ",
            "Obscenity",
            "Other Narcotic Violation",
            "Other Offence",
            "Prostitution",
            "Public Peace Violation",
            "Ritualism",
            "Sex Offence",
            "Weapons Violation",
            "Arson",
            "Assault",
            "Battery",
            "Concealed carry Licence",
            "Domestic Violence",
            "Gambling",
            "Human Trafficking",
            "Interference with Public officer",
            "Intimidation",
            "Kidnapping",
            "Liquor law violation",
            "Non Criminal",
            "Offence Involving Children",
            "Public indecency",
            "Robbery",
            "Stalking",
            "Theft"});
            this.CrimeTypeCmbBx.Location = new System.Drawing.Point(194, 117);
            this.CrimeTypeCmbBx.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.CrimeTypeCmbBx.Name = "CrimeTypeCmbBx";
            this.CrimeTypeCmbBx.Size = new System.Drawing.Size(180, 28);
            this.CrimeTypeCmbBx.TabIndex = 4;
            this.CrimeTypeCmbBx.Text = "Select";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(126, 274);
            this.button1.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(112, 35);
            this.button1.TabIndex = 6;
            this.button1.Text = "Submit";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 60);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(54, 20);
            this.label1.TabIndex = 7;
            this.label1.Text = "Month";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(32, 129);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 20);
            this.label2.TabIndex = 8;
            this.label2.Text = "CrimeType";
            // 
            // UserInput
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(426, 402);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.CrimeTypeCmbBx);
            this.Controls.Add(this.MonthCmbBx);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "UserInput";
            this.Text = "Crime Prediction";
            this.Load += new System.EventHandler(this.UserInput_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox MonthCmbBx;
        private System.Windows.Forms.ComboBox CrimeTypeCmbBx;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
    }
}