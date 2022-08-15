import { ProfessorDto } from './professor.model';

export interface SubjectDto {
  id: number;
  name: string;
  description: string;
  noOfEsp: number;
  yearOfStudy: number;
  semester: string;
  professors: ProfessorDto[];
}
