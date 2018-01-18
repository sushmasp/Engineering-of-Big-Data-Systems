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
            this.DistCmbBx = new System.Windows.Forms.ComboBox();
            this.RaceCmbBx = new System.Windows.Forms.ComboBox();
            this.DomesticCmbBx = new System.Windows.Forms.ComboBox();
            this.button1 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // DistCmbBx
            // 
            this.DistCmbBx.FormattingEnabled = true;
            this.DistCmbBx.Items.AddRange(new object[] {
            "Select",
            "Central",
            "Wentworth",
            "Grand Crossing",
            "South Chicago",
            "Calumet",
            "Gresham",
            "Englewood",
            "Chicago Lawn",
            "Deering",
            "Ogden",
            "Harrison",
            "Near West",
            "Shakespeare",
            "Austin",
            "Jefferson Park",
            "Albany Park",
            "Near North",
            "Town Hall",
            "Lincoln",
            "Morgan Park",
            "Rogers Park",
            "Grand Central",
            "Prairie Shores",
            "Chrysler Village",
            "Rosemoor"});
            this.DistCmbBx.Location = new System.Drawing.Point(194, 48);
            this.DistCmbBx.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.DistCmbBx.Name = "DistCmbBx";
            this.DistCmbBx.Size = new System.Drawing.Size(180, 28);
            this.DistCmbBx.TabIndex = 0;
            this.DistCmbBx.Text = "Select";
            this.DistCmbBx.SelectedIndexChanged += new System.EventHandler(this.DistCmbBx_SelectedIndexChanged);
            // 
            // RaceCmbBx
            // 
            this.RaceCmbBx.AutoCompleteCustomSource.AddRange(new string[] {
            "Black",
            "White",
            "Others"});
            this.RaceCmbBx.FormattingEnabled = true;
            this.RaceCmbBx.Items.AddRange(new object[] {
            "Select",
            "Asian",
            "Black",
            "White",
            "Others"});
            this.RaceCmbBx.Location = new System.Drawing.Point(194, 117);
            this.RaceCmbBx.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.RaceCmbBx.Name = "RaceCmbBx";
            this.RaceCmbBx.Size = new System.Drawing.Size(180, 28);
            this.RaceCmbBx.TabIndex = 4;
            this.RaceCmbBx.Text = "Select";
            // 
            // DomesticCmbBx
            // 
            this.DomesticCmbBx.FormattingEnabled = true;
            this.DomesticCmbBx.Items.AddRange(new object[] {
            "Select",
            "True",
            "False"});
            this.DomesticCmbBx.Location = new System.Drawing.Point(194, 182);
            this.DomesticCmbBx.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.DomesticCmbBx.Name = "DomesticCmbBx";
            this.DomesticCmbBx.Size = new System.Drawing.Size(180, 28);
            this.DomesticCmbBx.TabIndex = 5;
            this.DomesticCmbBx.Text = "Select";
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
            this.label1.Size = new System.Drawing.Size(58, 20);
            this.label1.TabIndex = 7;
            this.label1.Text = "District";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(32, 129);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(47, 20);
            this.label2.TabIndex = 8;
            this.label2.Text = "Race";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(32, 194);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(76, 20);
            this.label3.TabIndex = 9;
            this.label3.Text = "Domestic";
            // 
            // UserInput
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(426, 402);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.DomesticCmbBx);
            this.Controls.Add(this.RaceCmbBx);
            this.Controls.Add(this.DistCmbBx);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "UserInput";
            this.Text = "Crime Prediction";
            this.Load += new System.EventHandler(this.UserInput_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox DistCmbBx;
        private System.Windows.Forms.ComboBox RaceCmbBx;
        private System.Windows.Forms.ComboBox DomesticCmbBx;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
    }
}