import {Injectable} from '@angular/core'
import {Movie} from '../Movie'
import {Observable} from 'rxjs'
import {HttpClient} from '@angular/common/http'

@Injectable({providedIn: 'root'})
export class MasterlistService {
  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Movie[]> {
    return this.httpClient.get<Movie[]>('http://localhost:8080/movies')
  }
}
