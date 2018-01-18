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
            

            if (DistCmbBx.SelectedItem == "Select")
            {
                MessageBox.Show("Please select District");
            }
            else if (RaceCmbBx.SelectedItem == "Select")
            {
                MessageBox.Show("Please select Race");
            }
            else if (DomesticCmbBx.SelectedItem == "Select")
            {
                MessageBox.Show("Please select Domestic");
            }
            else
            {
                for (int i = 0; i < 25; i++)
                {
                    if (DistCmbBx.SelectedIndex == i + 1)
                        x += "1,";
                    else
                        x += "0,";
                }

                for (int i = 0; i < 4; i++)
                {
                    if (RaceCmbBx.SelectedIndex == i + 1)
                        x += "1,";
                    else
                        x += "0,";
                }

                if (DomesticCmbBx.SelectedItem == "True")
                    x = x + "1";
                else
                    x = x + "0";

                //MessageBox.Show(x.ToString());                
            }
            this.Close();
        
        }

        private void DistCmbBx_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
      
    }
}
