import { Injectable } from '@angular/core';
import {Movie} from '../Movie'
import {Observable, of} from 'rxjs'

@Injectable({
  providedIn: 'root'
})

export class WatchedlistService {
  constructor() { }

  movies: Movie[] = []

  getAll(): Observable<Movie[]> {
    const moviesValues = this.movies.slice()
    return of(moviesValues)
  }

  add(movie: Movie): Observable<Movie[]> {
    this.movies.push(movie)
    return this.getAll()
  }

  remove(movie: Movie): Observable<Movie[]> {
    this.movies = this.movies.filter(m => m.id !== movie.id)
    return this.getAll()
  }
}
