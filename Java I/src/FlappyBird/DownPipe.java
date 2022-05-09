package FlappyBird;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DownPipe extends Pipe {

	public DownPipe(int x, int y, int w, int h) throws IOException {
		super(x, y, w, h, ImageIO.read(new File("Images/flappyDPipe.png")).getScaledInstance(w, h, Image.SCALE_SMOOTH));
	}

}
