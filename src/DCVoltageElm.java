class DCVoltageElm extends VoltageElm {
	public DCVoltageElm(int xx, int yy) {
		super(xx, yy, WF_DC);
	}

	@Override
	Class getDumpClass() {
		return VoltageElm.class;
	}

	@Override
	int getShortcut() {
		return 'v';
	}
}
