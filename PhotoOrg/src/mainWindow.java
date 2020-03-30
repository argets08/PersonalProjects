
/*
 * Name: Tanmaya Kumar
 * Date: 10/3/2016
 * Prj: Photo Organizer v1
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.Object;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class mainWindow {

	private JFrame frame;
	private JTextField txtSelectMasterFolder;
	private String backupPath = "C:/";
	private JTextField txtNewNamingConvention;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Define Buttons and Panels
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_6207281515718");
		panel.setLayout(null);

		JButton btnBackup = new JButton("Backup");
		btnBackup.setBounds(148, 121, 89, 23);
		panel.add(btnBackup);

		JButton btnCancelExit = new JButton("Cancel & Exit");
		btnCancelExit.setBounds(320, 227, 104, 23);
		panel.add(btnCancelExit);

		JButton btnProceed = new JButton("Proceed >>");
		btnProceed.setBounds(204, 227, 104, 23);
		panel.add(btnProceed);

		// Text Panel and Folder Declaration
		txtSelectMasterFolder = new JTextField();
		txtSelectMasterFolder.setText("Select Master Folder w/ Photos");
		txtSelectMasterFolder.setBounds(148, 29, 213, 20);
		panel.add(txtSelectMasterFolder);
		txtSelectMasterFolder.setColumns(10);

		// Folder Chooser Button
		String title = "Select Images Folder";

		JButton btnBrowsePath = new JButton("Browse Path");
		btnBrowsePath.setBounds(21, 28, 99, 23);
		panel.add(btnBrowsePath);
		btnBrowsePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				// chooser.setCurrentDirectory(new java.io.File("C:/"));
				chooser.setCurrentDirectory(new java.io.File("E:/DevTest Images/Phone Pics 2013 2014"));
				chooser.setDialogTitle(title);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					txtSelectMasterFolder.setText(chooser.getSelectedFile().toString());
					backupPath = chooser.getSelectedFile().getParentFile().toString();
					System.out.println(backupPath);
					System.out.println(
							txtSelectMasterFolder.getText() + "/PhotOrg_Temp_Backup_" + System.currentTimeMillis());
				} else {
					txtSelectMasterFolder.setText("No Directory Selected");
				}
			}
		});

		// Checkbox for backup
		JCheckBox chckbxBackupOption = new JCheckBox("Do Not Back-up Images");
		chckbxBackupOption.setBounds(147, 56, 137, 23);
		panel.add(chckbxBackupOption);

		JTextPane txtpnBackupCreatedAt = new JTextPane();
		txtpnBackupCreatedAt.setForeground(new Color(0, 0, 0));
		txtpnBackupCreatedAt.setBackground(new Color(211, 211, 211));
		txtpnBackupCreatedAt.setEnabled(false);
		txtpnBackupCreatedAt.setText("Backup Created at:");
		txtpnBackupCreatedAt.setBounds(148, 153, 150, 20);
		panel.add(txtpnBackupCreatedAt);
		
		JPanel processPanel = new JPanel();
		frame.getContentPane().add(processPanel, "name_25264708822695");
		processPanel.setLayout(null);
		
		txtNewNamingConvention = new JTextField();
		txtNewNamingConvention.setText("New Naming Convention");
		txtNewNamingConvention.setBounds(280, 11, 144, 20);
		processPanel.add(txtNewNamingConvention);
		txtNewNamingConvention.setColumns(10);
		
		JCheckBox chckbxAssignNewNaming = new JCheckBox("Assign New Naming (Deafult is Date Based)");
		chckbxAssignNewNaming.setBounds(19, 10, 239, 23);
		processPanel.add(chckbxAssignNewNaming);
		
		JButton btnCancelExit_1 = new JButton("Cancel & Exit");
		btnCancelExit_1.setBounds(293, 227, 131, 23);
		processPanel.add(btnCancelExit_1);
		
		JButton btnBack = new JButton("<< Back");
		btnBack.setBounds(19, 227, 89, 23);
		processPanel.add(btnBack);
		
		JButton btnProceed2 = new JButton("Proceed >>");
		btnProceed2.setBounds(192, 227, 91, 23);
		processPanel.add(btnProceed2);
		
		JTextPane txtpnSortSelction = new JTextPane();
		txtpnSortSelction.setText("Sort Selction:");
		txtpnSortSelction.setBounds(155, 49, 70, 20);
		processPanel.add(txtpnSortSelction);
		
		JCheckBox chckbxYear = new JCheckBox("Year");
		chckbxYear.setBounds(19, 92, 97, 23);
		processPanel.add(chckbxYear);
		
		JCheckBox chckbxMonth = new JCheckBox("Month");
		chckbxMonth.setBounds(118, 92, 97, 23);
		processPanel.add(chckbxMonth);
		
		JCheckBox chckbxDay = new JCheckBox("Day");
		chckbxDay.setBounds(219, 92, 97, 23);
		processPanel.add(chckbxDay);
		
		JCheckBox chckbxHours = new JCheckBox("Hours");
		chckbxHours.setBounds(318, 92, 97, 23);
		processPanel.add(chckbxHours);
		
		JCheckBox chckbx8H = new JCheckBox("8 Hours");
		chckbx8H.setEnabled(false);
		chckbx8H.setBounds(318, 118, 97, 23);
		processPanel.add(chckbx8H);
		
		JCheckBox chckbx4H = new JCheckBox("4 Hours");
		chckbx4H.setEnabled(false);
		chckbx4H.setBounds(318, 144, 97, 23);
		processPanel.add(chckbx4H);
		
		JCheckBox chckbx2H = new JCheckBox("2 Hours");
		chckbx2H.setEnabled(false);
		chckbx2H.setBounds(318, 170, 97, 23);
		processPanel.add(chckbx2H);
		
		JCheckBox chckbx1H = new JCheckBox("1 Hour");
		chckbx1H.setEnabled(false);
		chckbx1H.setBounds(318, 196, 97, 23);
		processPanel.add(chckbx1H);
		
		JCheckBox chckbxDaily = new JCheckBox("Daily");
		chckbxDaily.setEnabled(false);
		chckbxDaily.setBounds(219, 118, 97, 23);
		processPanel.add(chckbxDaily);
		
		JCheckBox chckbxWeekly = new JCheckBox("Weekly");
		chckbxWeekly.setEnabled(false);
		chckbxWeekly.setBounds(219, 144, 97, 23);
		processPanel.add(chckbxWeekly);
		
		JCheckBox chckbxBiWeekly = new JCheckBox("Bi Weekly");
		chckbxBiWeekly.setEnabled(false);
		chckbxBiWeekly.setBounds(219, 170, 97, 23);
		processPanel.add(chckbxBiWeekly);
		
		JCheckBox chckbx1Mo = new JCheckBox("1 Month");
		chckbx1Mo.setEnabled(false);
		chckbx1Mo.setBounds(118, 118, 97, 23);
		processPanel.add(chckbx1Mo);
		
		JCheckBox chckbx6Mo = new JCheckBox("6 Month");
		chckbx6Mo.setEnabled(false);
		chckbx6Mo.setBounds(118, 144, 97, 23);
		processPanel.add(chckbx6Mo);
		chckbxBackupOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxBackupOption.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Selecting this will NOT create a Backup of the Images");
					btnBackup.setEnabled(false);
				} else {
					btnBackup.setEnabled(true);
				}
					
			}
		});

		// backup Button. Will be removed and action moved to Proceed option -
		// crate a copy off all images in the folder

		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSelectMasterFolder.getText().equals("Select Master Folder w/ Photos")
						|| txtSelectMasterFolder.getText().equals("No Directory Selected")) {
					JOptionPane.showMessageDialog(frame, "Select a Folder First");
				} else {
					File srcDir = new File(txtSelectMasterFolder.getText());
					File destDir = new File(backupPath + "/PhotOrg_Temp_Backup_" + System.currentTimeMillis());

					fileMover fm = new fileMover();
					try {
						fm.copy(srcDir, destDir);
						txtpnBackupCreatedAt.setText(txtpnBackupCreatedAt.getText() +" "+destDir.toString());
						JOptionPane.showMessageDialog(frame, "Backup Completed at "+destDir.toString());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSelectMasterFolder.getText().equals("Select Master Folder w/ Photos")
						|| txtSelectMasterFolder.getText().equals("No Directory Selected")) {
					JOptionPane.showMessageDialog(frame, "Select a Folder First");
				} else {
					File srcDir = new File(txtSelectMasterFolder.getText());
					//File destDir = new File(txtSelectMasterFolder.getText().toString() + "/PhotOrg_Temp_Backup_USES");
					fileMover reOrg = new fileMover();
					try {
						reOrg.destroyArchitecture(srcDir);
						processPanel.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

	}
}
