import { Injectable } from '@angular/core'
import {Movie} from '../Movie'
import {Observable, of} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  constructor() { }

  getMovies(): Observable<Movie[]> {
    return of([
      {id: 1, name: 'Get Out'},
      {id: 2, name: 'Django Unchained'},
      {id: 3, name: 'Red Cliff'},
      {id: 4, name: 'Esther'},
      {id: 5, name: 'The Post'},
      {id: 6, name: 'Spotlight'},
      {id: 7, name: 'Split'},
      {id: 8, name: 'Old Boy'}
    ])
  }
}
