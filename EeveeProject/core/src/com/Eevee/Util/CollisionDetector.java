package com.Eevee.Util;

import java.awt.Shape;
import java.awt.geom.Area;

import com.badlogic.gdx.math.Ellipse;

public class CollisionDetector {
	public static boolean collide(Ellipse e1, Ellipse e2) {
		double MidX1 = e1.x + e1.width / 2;
		double MidY1 = e1.y + e1.height / 2;
		double MidX2 = e2.x + e2.width / 2;
		double MidY2 = e2.y + e2.height / 2;
		double distX = Math.abs(MidX1 - MidX2);
		double distY = Math.abs(MidY1 - MidY2);

		double distance = Math.sqrt((distX * distX) + (distY * distY));

		double a1 = e1.width / 2;

		double a2 = e2.width / 2;

		double b1 = e1.height / 2;

		double b2 = e2.height / 2;

		double distanceSq = distance * distance;

		double distXSq = distX * distX;

		double distYSq = distY * distY;

		double line1 = (((distXSq / distanceSq) * a1) + ((distYSq / distanceSq) * b1));

		double line2 = (((distXSq / distanceSq) * a2) + ((distYSq / distanceSq) * b2));

		return ((line1 + line2) >= distance);

	}

	public static boolean testIntersection(Shape shapeA, Shape shapeB) {
		Area areaA = new Area(shapeA);
		areaA.intersect(new Area(shapeB));
		return !areaA.isEmpty();
	}

	public static boolean testIntersection(Area a, Area b) {
		a.intersect(b);
		return !a.isEmpty();
	}
}
