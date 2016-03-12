package Call_Center;

import java.util.*;

public class CallHandler {
  private static CallHandler instance = null;
  private final int LEVELS = 3;
  private final int RESPONDENTS = 10;
  private final int MANAGER = 4;
  private final int DIRECTORS = 2;
  private Map<Integer, List<Employee>> employees;//1 for respondent, 2 for manager, 3 for director
  private Map<Integer, Queue<Call>> callQueue;

  private CallHandler() {
    this.employees = new HashMap<>();
    this.callQueue = new HashMap<>();

    // initialize employees
    for (int i = 1; i <= this.LEVELS; i++) {
      this.employees.put(i, new ArrayList<>());
    }
    for (int i = 0; i < this.DIRECTORS; i++) {
      this.employees.get(3).add(new Director(i));
    }
    for (int i = 0; i < this.MANAGER; i++) {
      this.employees.get(2).add(new Manager(i));
    }
    for (int i = 0; i < this.RESPONDENTS; i++) {
      this.employees.get(1).add(new Respondent(i));
    }

    //initialize call queues
    for (int i = 1; i <= this.LEVELS; i++) {
      this.callQueue.put(i, new LinkedList<>());
    }
  }

  /**
   * Return the singleton object of CallHandler class.
   *
   * @return singleton object.
   */
  public static CallHandler getInstance() {
    if (instance == null) {
      instance = new CallHandler();
    }
    return instance;
  }

  /**
   * Dispatch call to available employee. If no employee available, add the call to the callQueue
   * according to the its level.
   *
   * @param call Call object
   */
  public void dispatchCall(Call call) {
    if (call == null) {
      return;
    }
    Employee emp = getEmployee(call);
    if (emp == null) {
      callQueue.get(call.getLevel()).add(call);
    }
    else {
      emp.receiveCall(call);
    }
  }

  // find the next available employee, starting from the level of the call.
  private Employee getEmployee(Call call) {
    for (int i = call.getLevel(); i <= this.LEVELS; i++) {
      List<Employee> empList = employees.get(i);
      if (!empList.isEmpty()) {
        for (Employee emp : empList) {
          if (emp.isFree()) {
            return emp;
          }
        }
      }
    }
    return null;
  }

  /**
   * Assign a call in the call queue according to the employee's level.
   *
   * @param emp Employee Object
   */
  public void assignCall(Employee emp) {
    if (emp == null) {
      return;
    }
    for (int i = emp.getLevel(); i >= 1; i--) {
      Queue<Call> q = callQueue.get(i);
      if (!q.isEmpty()) {
        emp.receiveCall(q.poll());
        return;
      }
    }
  }
}
