import { Professor } from "./professor.model";

export interface Subject{
  id: number;
  name: string;
  description: string;
  noOfEsp: number;
  yearOfStudy: number;
  semester: string;
  professors: Professor[];
}
