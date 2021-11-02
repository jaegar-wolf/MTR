package algorithms;

import java.awt.Point;
import java.util.ArrayList;

/***************************************************************
 * TME 1: calcul de diamètre et de cercle couvrant minimum.    *
 *   - Trouver deux points les plus éloignés d'un ensemble de  *
 *     points donné en entrée.                                 *
 *   - Couvrir l'ensemble de poitns donné en entrée par un     *
 *     cercle de rayon minimum.                                *
 *                                                             *
 * class Circle:                                               *
 *   - Circle(Point c, int r) constructs a new circle          *
 *     centered at c with radius r.                            *
 *   - Point getCenter() returns the center point.             *
 *   - int getRadius() returns the circle radius.              *
 *                                                             *
 * class Line:                                                 *
 *   - Line(Point p, Point q) constructs a new line            *
 *     starting at p ending at q.                              *
 *   - Point getP() returns one of the two end points.         *
 *   - Point getQ() returns the other end point.               *
 ***************************************************************/
import supportGUI.Circle;
import supportGUI.Line;

public class DefaultTeam {

  // calculDiametre: ArrayList<Point> --> Line
  //   renvoie une paire de points de la liste, de distance maximum.
  public Line calculDiametre(ArrayList<Point> points) {
    if (points.size()<3) {
      return null;
    }

    Point p=points.get(0);
    Point q=points.get(1);
    

    /*******************
     * PARTIE A ECRIRE *
     *******************/

    return new Line(p,q);
  }

  // calculCercleMin: ArrayList<Point> --> Circle
  //   renvoie un cercle couvrant tout point de la liste, de rayon minimum.
  public Circle calculCercleMin(ArrayList<Point> points) {
    if (points.isEmpty()) {
      return null;
    }

    for (Point p : points) {
    	for(Point q : points ) {
    		double cx = 0.5*(p.getX() + q.getX());
    		double cy = 0.5*(p.getY() + q.getY());
    		double cr = 0.5*p.distance(q);
    		boolean couvretoutlemonde = true;
    		for (Point r : points) {
    			if((Math.pow(r.getX()-cx, 2) + Math.pow(r.getY()-cy,2)) >= cr*cr) {
    				couvretoutlemonde = false;
    				break;
    			}
    			if(couvretoutlemonde) {
    				return new Circle(new Point((int)cx, (int)cy), (int) cr);
    				
    			}
    		}
    	}
    }    

    return new Circle(new Point(100,100), 100);
  }
}
