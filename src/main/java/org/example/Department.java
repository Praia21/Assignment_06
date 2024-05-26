package org.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1 ;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + String.format("%02d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * Validates a department name
     * @param departmentName the department name to be validated
     * @return true if the department name is valid, false if not
     */
    public static boolean validateDepartmentName(String departmentName) {
        return departmentName != null && departmentName.matches("[a-zA-Z ]+");
    }
    public void setDepartmentName(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentName = departmentName;
        }
    }

    @Override
    public String toString() {
        return departmentId + ": " + departmentName;
    }

    /**
     * Compares this department to another object for equality
     * @param obj the object to compare to
     * @return true if the objects are equal, if not is false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department that = (Department) obj;
        return departmentId.equals(that.departmentId) && departmentName.equals(that.departmentName);
    }
}



