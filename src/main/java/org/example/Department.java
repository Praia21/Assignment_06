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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId.equals(that.departmentId) && departmentName.equals(that.departmentName);
    }
}



