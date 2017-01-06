
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Checker {

	public static void main(String args[]) {

		int width;
		int height;
		BufferedImage bi;
		File dir = new File(
				"C:\\Users\\Superman\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets\\");

		String[] children = dir.list();

		if (children == null) {
			System.out.println("No dir");// No directory
		} else {
			for (int i = 0; i < children.length; i++) {
				// Get filename of file or directory
				x: {
					String filename = children[i];

					System.out.println(filename);
					try {
						bi = ImageIO.read(new File(dir + "\\" + filename));
						if (bi == null)
							break x;
						System.out.println(bi);
						width = bi.getWidth();
						height = bi.getHeight();
						if (width >= 1920 && height >= 1080) {
							save(bi, filename);
						}

						System.out.println("width: " + width);
						System.out.println("height: " + height);

					} catch (IOException e) {

					}
				}
			}
		}
	}

	public static void save(BufferedImage bi, String filename) throws IOException {

		File outputfile = new File("C:\\Users\\Superman\\Desktop\\Spotlight Images\\image"+filename+".jpg");
		ImageIO.write(bi, "jpg", outputfile);
	}
}
