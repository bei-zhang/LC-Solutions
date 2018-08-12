package dataStructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * http://www.lintcode.com/en/problem/course-schedule/
 * http://www.jiuzhang.com/solutions/course-schedule/
 * 
 * http://blog.csdn.net/ljiabin/article/details/45846837
 * http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
 * 
 *
 *
 */
public class CourseSchedule {
	
	
	/**
	 * 
	 * Time complexity: O(N + M),  this is standard time complexity for BSF on graph. 
	 */
	class Solution1 {

		   /**
	     * @param numCourses a total of n courses
	     * @param prerequisites a list of prerequisite pairs
	     * @return true if can finish all courses or false
	     */
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        
	        int[] indegree = new int[numCourses];
	        
	        //This extra array to save all adjacency vertices of a source vertex. 
	        //e.g. 0->1 , 0->3, 0>6, it saves [1,3,6] as ArrayList for the source vertex of 0.
	        List[] edges = new ArrayList[numCourses];
	        
	        for(int i=0;i<numCourses;i++){
	        	edges[i] = new ArrayList<Integer>();
	        }
	        //1. Count indegree for each course (vertex)
	        for(int i=0; i<prerequisites.length;i++){
	            indegree[prerequisites[i][0]] ++;
	            edges[prerequisites[i][1]].add(prerequisites[i][0]);
	        }

	        //2. BSF        
	        Queue<Integer> queue = new LinkedList<>();
	        
	        for(int course=0; course<numCourses; course++){
	            if(indegree[course] == 0){
	                queue.offer(course);
	            }
	        }
	        
	        //典型的拓扑排序。原理也很简单，在一个有向图中，每次找到一个没有前驱节点的节点（也就是入度为0的节点），然后把它指向其他节点的边都去掉，重复这个过程（BFS），直到所有节点已被找到，或者没有符合条件的节点（如果图中有环存在）。
	        
	        int count = 0;
	        while(!queue.isEmpty()){
	            int course = queue.poll();
	            count ++;
	            int size =  edges[course].size();
	            for(int i=0; i<size;i++){
	            	int pointer = (int) edges[course].get(i);
	            	indegree[pointer] --;
	            	if(indegree[pointer] == 0){
	                    queue.offer(pointer);
	                }
	             
	            }
	            
	        }
	        
	        return count == numCourses;
	        
	    }
	    
	}
	
	
//---------------------------------------------------------------------------------	
//---------------------------------------------------------------------------------	
	
	/**
	 * 此办法每次都要loop 所有 prerequisites， time complexity is worse than solution#1.
	 * Time complexity: O(N*M)
	 *
	 */
	class Solution2 {
		 public boolean canFinish(int numCourses, int[][] prerequisites) {
			 
			 
			 int[] result;
			 result = new int[0];
             
		        int[] indegree = new int[numCourses];
		        
		        //1. Count indegree for each course (vertex)
		        for(int i=0; i<prerequisites.length;i++){
		            indegree[prerequisites[i][0]] ++;
		        }

		        //2. BSF        
		        Queue<Integer> queue = new LinkedList<>();
		        
		        for(int course=0; course<numCourses; course++){
		            if(indegree[course] == 0){
		                queue.offer(course);
		            }
		        }
		        
		        //典型的拓扑排序。原理也很简单，在一个有向图中，每次找到一个没有前驱节点的节点（也就是入度为0的节点），然后把它指向其他节点的边都去掉，重复这个过程（BFS），直到所有节点已被找到，或者没有符合条件的节点（如果图中有环存在）。
		        
		        int count = 0;
		        while(!queue.isEmpty()){
		            int head = queue.poll();
		            count ++;
		            for(int i=0; i<prerequisites.length;i++){ 
		                if(prerequisites[i][1] == head){
		                    indegree[prerequisites[i][0]] --;
		                    if(indegree[prerequisites[i][0]] == 0){
		                        queue.offer(prerequisites[i][0]);
		                    }
		                }
		            }
		            
		        }
		        
		        return count == numCourses;
		        
		    }
		 
	}

	
	
}
