/**
   This class encapsulates a work order with a priority.
*/
public class WorkOrder implements Comparable<WorkOrder>
{
   private int priority;
   private String description;

   /**
      Constructs a work order with a given priority and description.
      @param aPriority the priority of this work order
      @param aDescription the description of this work order
   */
   public WorkOrder(int aPriority, String aDescription)
   {
      priority = aPriority;
      description = aDescription;
   }

   public String toString()
   {
      return "priority=" + priority + ", description=" + description;
   }

   public int compareTo(WorkOrder obj)
   {
      WorkOrder other = (WorkOrder) obj;
      if (priority < other.priority) { return -1; }
      else if (priority > other.priority) { return 1; }
      else { return 0; }
   }
}
