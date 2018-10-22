import {Component, Input, OnInit} from '@angular/core'
import {Movie} from '../Movie'
import {MovieService} from '../movie.service'

@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrls: ['./list-manager.component.scss']
})
export class ListManagerComponent implements OnInit {

  constructor(private service: MovieService) { }

  masterListTitle = 'All Movies'
  masterList: Movie[]

  wishListTitle = 'Wish List'
  wishList: Movie[] = []

  watchedListTitle = 'Watched'
  watchedList: Movie[] = []

  ngOnInit() {
    this.getMovies()
  }

  private getMovies(): void {
    this.service.getMovies()
      .subscribe(movies => this.masterList = movies)
  }
}
