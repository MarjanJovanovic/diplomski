import { ExamPeriodDto } from './exam-period.model';
import { ProfessorDto } from './professor.model';
import { SubjectDto } from './subject.model';

export interface ExamDto {
  id: number;
  date: Date;
  examPeriod: ExamPeriodDto;
  professor: ProfessorDto;
  subject: SubjectDto;
}
