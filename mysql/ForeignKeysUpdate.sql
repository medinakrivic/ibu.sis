#International Burch University
#Foreign keys update for database

USE StudentIS;

ALTER TABLE Students 
ADD CONSTRAINT FK_Cities
FOREIGN KEY (CityID) REFERENCES Cities(CityID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Students 
ADD CONSTRAINT FK_BirthCities
FOREIGN KEY (BirthCityID) REFERENCES Cities(CityID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Students
ADD CONSTRAINT FK_States
FOREIGN KEY (StateID) REFERENCES States(StateID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Students
ADD CONSTRAINT FK_BirthStates
FOREIGN KEY (BirthStateID) REFERENCES States(StateID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Students
ADD CONSTRAINT FK_Faculities
FOREIGN KEY (FacultyID) REFERENCES Faculties(FacultyID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Students
ADD CONSTRAINT FK_Departments
FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Cities
ADD CONSTRAINT FK_StateCity
FOREIGN KEY (StateID) REFERENCES States(StateID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentStatuses
ADD CONSTRAINT FK_StatusStudentID
FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentStatuses
ADD CONSTRAINT FK_WayOfStuding
FOREIGN KEY (WayOfStudyID) REFERENCES WaysOfStuding(WayOfStudyID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentStatuses
ADD CONSTRAINT FK_StatusSchoolYear
FOREIGN KEY (SchoolYear) REFERENCES SchoolYears(SchoolYear)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentStatuses
ADD CONSTRAINT FK_ChangeStatus
FOREIGN KEY (StatusID) REFERENCES Statuses(StatusID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentGrades
ADD CONSTRAINT FK_GradesStudentID
FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentGrades
ADD CONSTRAINT FK_GradesEducatorID
FOREIGN KEY (EducatorID) REFERENCES Educators(EducatorID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Educators
ADD CONSTRAINT FK_EducatorsRankID
FOREIGN KEY (RankID) REFERENCES Ranks(RankID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Educators
ADD CONSTRAINT FK_EducatorsTitlesID
FOREIGN KEY (TitleID) REFERENCES Titles(TitleID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Educators
ADD CONSTRAINT FK_EducatorsStatusID
FOREIGN KEY (EducatorStatusID) REFERENCES EducatorStatus(EducatorStatusID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE StudentSemesters
ADD CONSTRAINT FK_StuSemestersStuID
FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Plans
ADD CONSTRAINT FK_PlansSchoolYear
FOREIGN KEY (SchoolYearID) REFERENCES SchoolYears(SchoolYear)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Plans
ADD CONSTRAINT FK_PlansEducatorsID
FOREIGN KEY (EducatorID) REFERENCES Educators(EducatorID)
ON UPDATE CASCADE
ON DELETE CASCADE;