import { Component, OnInit } from '@angular/core'
import {Movie} from '../Movie'

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  constructor() { }

  movies: Movie[] = [
    {id: 1, name: 'Get Out'},
    {id: 2, name: 'Django Unchained'},
    {id: 3, name: 'Red Cliff'},
    {id: 4, name: 'Esther'}
  ]

  ngOnInit() {
  }

}
