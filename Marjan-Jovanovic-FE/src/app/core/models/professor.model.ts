import { SubjectDto } from './subject.model';

export interface ProfessorDto {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  address: string;
  city: string;

  phone: string;
  reelectionDate: Date;
  title: string;
  subjects: SubjectDto;
}
