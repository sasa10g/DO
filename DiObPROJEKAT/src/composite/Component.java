package composite;

import geometry.Shape;

public interface Component {
	void add(Shape s);
	void remove(Shape s);
}
