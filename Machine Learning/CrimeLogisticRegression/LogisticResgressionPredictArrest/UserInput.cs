using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UserInputTest
{
    public partial class UserInput : Form
    {
        public string x = "";
        public UserInput()
        {
            InitializeComponent();
        }

        private void UserInput_Load(object sender, EventArgs e)
        {
            this.Visible = true;

        }

        public void button1_Click(object sender, EventArgs e)
        {
            

            if (MonthCmbBx.SelectedItem == "Select")
            {
                MessageBox.Show("Please select Month");
            }
            else if (CrimeTypeCmbBx.SelectedItem == "Select")
            {
                MessageBox.Show("Please select Crime Type");
            }
           
            else
            {
                for (int i = 0; i < 12; i++)
                {
                    if (MonthCmbBx.SelectedIndex == i + 1)
                        x += "1,";
                    else
                        x += "0,";
                }

                for (int i = 0; i < 34; i++)
                {
                    if (CrimeTypeCmbBx.SelectedIndex == i + 1)
                        x += "1,";
                    else
                        x += "0,";
                }

                x = x.Substring(0, x.Length - 1);

                //MessageBox.Show(x.ToString());                
            }
            this.Close();
        
        }
      
    }
}
