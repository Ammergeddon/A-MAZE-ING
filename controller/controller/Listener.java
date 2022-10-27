package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;

public class Listener implements MouseListener{

	private void highlight_element(Object source) {
		try {
			source.getClass().getMethod("set_highlight").invoke(source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	private void set_normal(Object source) {
		try {
			source.getClass().getMethod("set_normal").invoke(source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.set_normal(e.getSource());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.highlight_element(e.getSource());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.highlight_element(e.getSource());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.set_normal(e.getSource());
	}

}
