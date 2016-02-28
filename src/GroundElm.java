import java.awt.Graphics;
import java.util.StringTokenizer;

class GroundElm extends CircuitElm {
	public GroundElm(int xx, int yy) {
		super(xx, yy);
	}

	public GroundElm(int xa, int ya, int xb, int yb, int f, StringTokenizer st) {
		super(xa, ya, xb, yb, f);
	}

	@Override
	int getDumpType() {
		return 'g';
	}

	@Override
	int getPostCount() {
		return 1;
	}

	@Override
	void draw(Graphics g) {
		setVoltageColor(g, 0);
		drawThickLine(g, point1, point2);
		int i;
		for (i = 0; i != 3; i++) {
			int a = 10 - i * 4;
			int b = i * 5; // -10;
			interpPoint2(point1, point2, ps1, ps2, 1 + b / dn, a);
			drawThickLine(g, ps1, ps2);
		}
		doDots(g);
		interpPoint(point1, point2, ps2, 1 + 11. / dn);
		setBbox(point1, ps2, 11);
		drawPost(g, x, y, nodes[0]);
	}

	@Override
	void setCurrent(int x, double c) {
		current = -c;
	}

	@Override
	void stamp() {
		sim.stampVoltageSource(0, nodes[0], voltSource, 0);
	}

	@Override
	double getVoltageDiff() {
		return 0;
	}

	@Override
	int getVoltageSourceCount() {
		return 1;
	}

	@Override
	void getInfo(String arr[]) {
		arr[0] = "ground";
		arr[1] = "I = " + getCurrentText(getCurrent());
	}

	@Override
	boolean hasGroundConnection(int n1) {
		return true;
	}

	@Override
	int getShortcut() {
		return 'g';
	}
}
