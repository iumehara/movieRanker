import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core'
import {Movie} from '../Movie'
import {WatchedlistService} from './watchedlist.service'

@Component({
  selector: 'app-watchedlist',
  templateUrl: './watchedlist.component.html',
  styleUrls: ['./watchedlist.component.css']
})
export class WatchedlistComponent implements OnInit {
  constructor(private watchedlistService: WatchedlistService) { }

  @Input() movies: Movie[]
  @Output() messageEvent = new EventEmitter<string>()

  ngOnInit() {
  }

  removeFromWatchedlist(movie: Movie) {
    this.watchedlistService.remove(movie)
    this.messageEvent.emit('WATCHEDLIST_UPDATED')
  }
}
