import {Component, OnInit} from '@angular/core'
import {Movie} from '../Movie'
import {MovieService} from '../services/movie.service'
import {WishlistService} from '../services/wishlist.service'

@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrls: ['./list-manager.component.scss']
})

export class ListManagerComponent implements OnInit {
  constructor(
    private movieService: MovieService,
    private wishListService: WishlistService
  ) { }

  wishlist: Movie[] = []
  wishlistIds: number[] = []
  masterlist: Movie[]

  ngOnInit() {
    this.getWishList()
    this.getMasterList()
  }

  receiveChildlistMessage($event) {
    if ($event === 'WISHLIST_UPDATED') {
      this.getWishList()
    }
  }

  private getMasterList(): void {
    this.movieService.getMovies()
      .subscribe(movies => this.masterlist = movies)
  }

  private getWishList(): void {
    this.wishListService.getAll()
      .subscribe(movies => {
        this.wishlist = movies
        this.wishlistIds = movies.map(movie => movie.id)
      })
  }
}
