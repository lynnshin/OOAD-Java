package obj;

import java.awt.Point;

public class port {

	Point[] portPoint;
	basicObj o;
	int pointIndex;
	
	public port(basicObj o) {
		this.o = o;
		this.connectPortCandidate();
	}
	
	public void connectPortCandidate() {
		portPoint = new Point[] {
				new Point(o.locX + o.width/2, o.locY),
				new Point(o.locX + o.width , o.locY + o.height/2),
				new Point(o.locX + o.width/2, o.locY + o.height),
				new Point(o.locX, o.locY + o.height/2)
		};
		for (Point p :portPoint) {
			System.out.println("[" + p.x +"," + p.y + "]");
		}		
	}
	
	public int connectPointIndex(Point point) {
		//算目前位置與四個port距離 取最近的當作起始點或終點
		double distance = Math.sqrt((portPoint[0].x-point.x)*(portPoint[0].x-point.x)+(portPoint[0].y-point.y)*(portPoint[0].y-point.y));
		double temp = distance;
		pointIndex = 0;
		for (int i = 1; i < portPoint.length; i++) {			
			distance = Math.sqrt((portPoint[i].x-point.x)*(portPoint[i].x-point.x)+(portPoint[i].y-point.y)*(portPoint[i].y-point.y));
			if (temp > distance) {
				temp = distance;
				pointIndex = i;
			}			
		}
		return pointIndex;			
	}
	
	public Point connectPoint(int pointIndex) {
		return new Point(portPoint[pointIndex].x,portPoint[pointIndex].y);
	}
}
