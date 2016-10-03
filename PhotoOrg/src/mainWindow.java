
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

public class mainWindow {

	private JFrame frame;
	private JTextField txtSelectMasterFolder;
	private String backupPath = "C:/";
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
		
		//Define Buttons and Panels
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
					System.out.println(txtSelectMasterFolder.getText() + "/PhotOrg_Temp_Backup_"+System.currentTimeMillis());
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
		chckbxBackupOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxBackupOption.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Selecting this will NOT create a Backup of the Images");
					btnBackup.setEnabled(false);
				}else btnBackup.setEnabled(true);
			}
		});

		// backup Button. Will be removed and action moved to Proceed option -
		// crate a copy off all images in the folder
		
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSelectMasterFolder.getText().equals("Select Master Folder w/ Photos") ||txtSelectMasterFolder.getText().equals("No Directory Selected")){
					JOptionPane.showMessageDialog(frame, "Select a Folder First");
				}
				else{
				File srcDir = new File(txtSelectMasterFolder.getText());
				File destDir = new File(backupPath + "/PhotOrg_Temp_Backup_"+System.currentTimeMillis());
				
				fileMover fm = new fileMover();
				try {
					fm.copy(srcDir, destDir);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			}
		});

	

	}
}
