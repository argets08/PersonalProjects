import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Object;
import org.apache.commons.io.*;

public class fileMover {

	public fileMover() {
	}

	// FileUtils.copyDirectory(srcDir, destDir);

	public void copy(File sourceLocation, File targetLocation) throws IOException {
		if (sourceLocation.isDirectory()) {
			copyDirectory(sourceLocation, targetLocation);
		} else {
			copyFile(sourceLocation, targetLocation);
		}
	}

	void copyDirectory(File source, File target) throws IOException {
		if (!target.exists()) {
			target.mkdir();
		}

		for (String f : source.list()) {
			copy(new File(source, f), new File(target, f));
		}
	}

	void copyFile(File source, File target) throws IOException {
		try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target)) {
			byte[] buf = new byte[1024];
			int length;
			while ((length = in.read(buf)) > 0) {
				out.write(buf, 0, length);
			}
			in.close();
			out.close();
		}
	}

	void destroyArchitecture(File source) throws IOException {
		// sequence iterator
		int value = 1;
		File[] listOfFiles;
		File[] directories = new File(source.getPath()).listFiles(File::isDirectory);
		for (File d : directories) {
			listOfFiles = d.listFiles();
			if (listOfFiles != null) {
				for (File child : listOfFiles) {

					String[] fileNameSplits = child.getName().split("\\.");
					// extension is assumed to be the last part
					int extensionIndex = fileNameSplits.length - 1;
					// add extension to id
					File newName = new File(
							source.getPath() + "\\PHOTORG_" + value + "." + fileNameSplits[extensionIndex]);

					// Move files to destination folder
					child.renameTo(newName);
					value++;
					System.out.println(newName.getName());
				}

				// Add if you want to delete the source folder
				d.delete();
			}
		}
		listOfFiles = source.listFiles();
		if (listOfFiles != null) {
			for (File child : listOfFiles) {

				// maintain file format (jpeg, jpg, png...)
				String[] fileNameSplits = child.getName().split("\\.");
				// extension is assumed to be the last part
				int extensionIndex = fileNameSplits.length - 1;
				// add extension to id
				File newName = new File(source.getPath() + "\\PHOTORG_" + value + "." + fileNameSplits[extensionIndex]);

				// Move files to destination folder
				child.renameTo(newName);
				value++;
				// Delete original
				child.delete();
				System.out.println(newName.getName());
			}
		} else {
			System.out.println(source + "  Folder does not exists");
		}
		System.out.println("File creation @ Target complete");
	}
//may need to flesh this out
	void renameAll(File source, String title) throws IOException {
					File[] listOfFiles = source.listFiles();
					
					
		}
}
