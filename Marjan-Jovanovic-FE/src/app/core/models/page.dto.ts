export interface Page<T> {
  totalElements: number;
  size: number;
  number:number;
  content: T;
}
