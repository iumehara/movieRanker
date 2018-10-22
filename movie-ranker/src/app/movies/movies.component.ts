import {Component, Input, OnInit} from '@angular/core'
import {Movie} from '../Movie'

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {
  constructor() { }

  @Input() movies: Movie[]
  @Input() title: string

  ngOnInit() {}
}
