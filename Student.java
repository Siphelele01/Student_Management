public class Student {
      //Declaration of data members
        private int rollNumber;
        private String surname;
        private String name;
        private String course;
        private int mark;
        //Non default constructors
        public Student(int rollNumber, String surname, String name, String course, int mark) {
            this.rollNumber = rollNumber;
            this.surname = surname;
            this.name = name;
            this.course = course;
            this.mark = mark;
        }
        //Getters
        public int getRollNumber() {
            return rollNumber;
        }

        public String getSurname() {
            return surname;
        }

        public String getName() {
            return name;
        }

        public String getCourse() {
            return course;
        }

        public int getMark() {
            return mark;
        }
        //ToString method
        @Override
        public String toString() {
            return "Name: " + name + ", Surname: " + surname + ", Roll Number: " + rollNumber + ", Course: " + course + ", Mark: " + mark;
        }

}
