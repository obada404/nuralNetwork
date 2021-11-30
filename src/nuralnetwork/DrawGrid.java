
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import nuralnetwork.NuralNetwork;
import nuralnetwork.all;

public class DrawGrid {

    private JFrame frame;
    double f;

    public DrawGrid() {

        all colection = new all();
        frame = new JFrame("Digits");
        frame.setSize(900, 585);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
      frame.add(new MultiDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel pane3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pane4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pane6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pane5 = new JPanel(new BorderLayout());
        Label label1 = new Label("Number Of Hidden Layer");
        Label label2 = new Label("Number Of Nural");
        Label label3 = new Label("Learning rate");
        Label label4 = new Label(" Maximum number of iterations");
        Label label5 = new Label("Activation function(Write 0 if you need Tanh fun and 1  if you need ReLU  ");
        label1.setFont(new Font("Verdana", Font.PLAIN, 20));
        label1.setForeground(Color.WHITE);
        label2.setFont(new Font("Verdana", Font.PLAIN, 20));
        label2.setForeground(Color.WHITE);
        label3.setFont(new Font("Verdana", Font.PLAIN, 20));
        label3.setForeground(Color.WHITE);
        label4.setFont(new Font("Verdana", Font.PLAIN, 20));
        label4.setForeground(Color.WHITE);
        label5.setFont(new Font("Verdana", Font.PLAIN, 20));
        label5.setForeground(Color.WHITE);
        JTextField text1 = new JTextField(10);
        JTextField text2 = new JTextField(10);
        JTextField text3 = new JTextField(10);
        JTextField text4 = new JTextField(10);
        JTextField text5 = new JTextField(4);
        text1.setText("2");
        text2.setText("20");
        text3.setText("0.8");
        text4.setText("10000");
        text5.setText("1");
        JButton button1 = new JButton("BLACK");
        JButton button0 = new JButton("GRAY");
        JButton button3 = new JButton("learning");
        JButton button4 = new JButton("test");
        JButton button5 = new JButton("Reset");
        button5.setBackground(Color.white);
        button1.setForeground(Color.green.darker());button1.setBackground(Color.white);
        button0.setForeground(Color.green.darker()); button0.setBackground(Color.white);
        button3.setForeground(Color.green.darker()); button3.setBackground(Color.white);
        button4.setForeground(Color.green.darker()); button4.setBackground(Color.white);
        button5.setForeground(Color.green.darker()); button5.setBackground(Color.white);

                         String[] headings = new String[] {
                         "      ",
                       "Class 0",
                        "Class 1",
                        "Class 2",
                        "Class 3",
                        "Class 4",
                        "Class 5",
                         "Class 6",
                        "Class 7",
                        "Class 8",
                        "Class 9"};
Object[][] data = new Object[][] {
          { "100420", Boolean.FALSE, "Des Moines IA", "Spokane WA",
              "02/06/2000", new Float(450) },
          { "202174", Boolean.TRUE, "Basking Ridge NJ", "Princeton NJ",
              "05/20/2000", new Float(1250) },
          { "450877", Boolean.TRUE, "St. Paul MN", "Austin TX",
              "03/20/2000", new Float(1745) },
          { "101891", Boolean.FALSE, "Boston MA", "Albany NY",
              "04/04/2000", new Float(88) }
        };
JTable table = new JTable(data, headings);
 
     
       
  
        

        // button0.setPreferredSize(new Dimension(0, 10));
        button0.setSize(new Dimension(20, 10));
        pane3.add(label1);
        pane3.add(text1);
        pane3.add(label2);
        pane3.add(text2);
        pane4.add(label3);
        pane4.add(text3);
        pane4.add(label4);
        pane4.add(text4);
        pane4.add(button1);
        pane4.add(button0);
        pane6.add(label5);
        pane6.add(text5);
        pane6.add(button5);
        pane3.add(button3);
        pane3.add(button4);

        pane5.add(pane3, BorderLayout.NORTH);
        pane5.add(pane4, BorderLayout.CENTER);
        pane5.add(pane6, BorderLayout.SOUTH);
  
   panel.setBackground(Color.green.darker());
   pane5.setBackground(Color.green.darker());
   pane3.setBackground(Color.green.darker());
   pane4.setBackground(Color.green.darker());
   pane6.setBackground(Color.green.darker());
        panel.add(pane5, BorderLayout.SOUTH);
 frame.add(new JScrollPane(table));
        frame.add(panel);

        int cellSize = 60;
        button0.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                f = 1;

            }
        });
        button1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                f = 0.5;

            }
        });
        button3.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                int numofhiden = Integer.parseInt(text1.getText());

                int numofnural = Integer.parseInt(text2.getText());
                int itration = Integer.parseInt(text4.getText());
                double alpha = Double.parseDouble(text3.getText());
              
                colection.input(numofnural, numofhiden, alpha,itration, mode(matrix));
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
             colection.train( mode(matrix));
            }
        });
        
        
        //reset
        button5.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 5; j++) {
                        matrix[i][i] = 0;
                    }
                }
              

            }
        });

    }

    public double[] mode(double[][] arr) {
        double[] oneDArray = new double[arr.length * arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int s = 0; s < arr[0].length; s++) {
                oneDArray[(i * arr.length) + s] = arr[i][s];
            }
        }
        return oneDArray;
    }

    public static void main(String... argv) {
        new DrawGrid();
    }

    double[][] matrix = new double[7][5];
    Color[][] grid = new Color[7][5];

    public class MultiDraw extends JPanel implements MouseListener {

        int startX = 10;
        int startY = 10;
        int cellSize = 75;
        int turn = 2;

        boolean winner = false;
        String ccolor = "";

        public MultiDraw(Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            //1. initialize array here
            int x = 0;
            for (int row = 0; row < 7; row++) {
                for (int col = 0; col < 5; col++) {
                    Color c;
                    if (x % 2 == 0) {
                        grid[row][col] = Color.white;
                    } else {
                        grid[row][col] = Color.white;
                    }
                    x++;

                }

            }
        }

        @Override
        public void paintComponent(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            Dimension d = getSize();
            g2.setColor(Color.green.darker());
            g2.fillRect(0, 0, 900, 800);
            
            startX = 0;
            startY = 0;

            //2) draw grid here
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {

                    g2.setColor(grid[row][col]);
                    g2.fillRect(startX, startY,cellSize, cellSize);
                    g2.setColor(Color.black);
                    g2.drawRect(startX, startY, cellSize, cellSize);

                    startX += cellSize;
                }
                startY += cellSize;
                startX = 0;
            }

            g2.setColor(new Color(255, 255, 255));

//
        }

        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            if (winner == false) {
                if (x < (cellSize * grid[0].length) && y < (cellSize * grid.length)) {
                    int clickedRow = y / cellSize;
                    int clickedCol = x / cellSize;

                    if (clickedRow != -1) {

                        //    if(turn%2==0){
                        if (f == 0) {
                            grid[clickedRow][clickedCol] = Color.black;
                            ccolor = "black";
                            matrix[clickedRow][clickedCol] = 1;
                        }
                        if (f == 1) {
                            grid[clickedRow][clickedCol] = Color.gray;
                            ccolor = "gray";
                            matrix[clickedRow][clickedCol] = (int) 0.5;

                        }

                    }
                }
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseClicked(MouseEvent e) {

        }

        //Marvel
    }//end of class
}
