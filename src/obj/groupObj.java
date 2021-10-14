package obj;

import java.util.Vector;

public class groupObj {

	public Vector<Vector<basicObj>> groupObjs = new Vector<Vector<basicObj>>();
	public Vector<basicObj> groupBy = new Vector<basicObj>();
	public Vector<Vector<basicObj>> groupBygroup = new Vector<Vector<basicObj>>();
	
	public groupObj() {

	}
	
	public void addchild(Vector<basicObj> b) {
		groupObjs.add(b);
	}
	
	public void removechild(Vector<basicObj> b) {
		groupObjs.remove(b);
	}
	
	public Vector<Vector<basicObj>> groupbygroup(){
		groupBy.clear();
		groupBygroup.clear();
		for(int i = groupObjs.size()-1; i >= 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				for(int k = 0; k < groupObjs.get(j).size(); k++) {
					if(groupObjs.get(i).contains(groupObjs.get(j).get(k))) {
						groupBy.addAll(groupObjs.get(i));//if[1,2],[3,4],[1,3] 
						groupBy.addAll(groupObjs.get(j));//groupBy = [1,3,3,4,1,2]
					}
				}
			}
			groupBygroup.add(groupBy);
		}
		
		return groupBygroup;
	}
}
