import { CityDto } from './city.model';

export interface StudentDto {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  address: string;
  city: CityDto;

  indexNumber: string;
  currentYearOfStudy: number;
  indexYear: string;
}
