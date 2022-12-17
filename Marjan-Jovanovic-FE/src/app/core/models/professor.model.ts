import { CityDto } from './city.model';
import { SubjectDto } from './subject.model';
import { TitleDto } from './title.model';

export interface ProfessorDto {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  address: string;
  city: CityDto;

  phone: string;
  reelectionDate: Date;
  title: TitleDto;
  subjects: SubjectDto;
}
