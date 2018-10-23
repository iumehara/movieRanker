import {Component, OnInit} from '@angular/core'
import {Movie} from '../Movie'
import {MovieService} from '../services/movie.service'
import {WishlistService} from '../wishlist/wishlist.service'
import {WatchedlistService} from '../watchedlist/watchedlist.service'

@Component({
  selector: 'app-list-manager',
  templateUrl: './list-manager.component.html',
  styleUrls: ['./list-manager.component.scss']
})

export class ListManagerComponent implements OnInit {
  constructor(
    private movieService: MovieService,
    private wishlistService: WishlistService,
    private watchedlistService: WatchedlistService
  ) { }

  wishlist: Movie[] = []
  wishlistIds: number[] = []

  watchedlist: Movie[] = []
  watchedlistIds: number[] = []

  masterlist: Movie[]

  ngOnInit() {
    this.getWishlist()
    this.getWatchedlist()
    this.getMasterList()
  }

  receiveChildlistMessage($event) {
    if ($event === 'WISHLIST_UPDATED') {
      this.getWishlist()
    }
    if ($event === 'WATCHEDLIST_UPDATED') {
      this.getWatchedlist()
    }
  }

  private getMasterList(): void {
    this.movieService.getMovies()
      .subscribe(movies => this.masterlist = movies)
  }

  private getWishlist(): void {
    this.wishlistService.getAll()
      .subscribe(movies => {
        this.wishlist = movies
        this.wishlistIds = movies.map(movie => movie.id)
      })
  }

  private getWatchedlist(): void {
    this.watchedlistService.getAll()
      .subscribe(movies => {
        this.watchedlist = movies
        this.watchedlistIds = movies.map(movie => movie.id)
      })
  }
}
