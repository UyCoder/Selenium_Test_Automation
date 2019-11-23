package com.seleniummaster.classtutorial;

public class School {
    private String name;
    private String location;
    private String type;

    public School() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static class Department {
        private String departmentName;
        private String depertmentLocation;
        public Department() {

        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getDepertmentLocation() {
            return depertmentLocation;
        }

        public void setDepertmentLocation(String depertmentLocation) {
            this.depertmentLocation = depertmentLocation;
        }
    }
}

