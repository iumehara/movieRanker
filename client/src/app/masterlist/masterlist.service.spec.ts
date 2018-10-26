import {MasterlistService} from './masterlist.service'
import {fakeAsync} from '@angular/core/testing'
import {of} from 'rxjs'

describe('MasterlistService', () => {
  describe('getAll', () => {
    it('returns list of movies', fakeAsync(() => {
      const spyHttpClient = jasmine.createSpyObj(['get'])
      const stubMovies = [
        {id: 1, name: 'movie 1'},
        {id: 2, name: 'movie 2'},
        {id: 3, name: 'movie 3'},
        {id: 4, name: 'movie 4'}
      ]
      spyHttpClient.get.and.returnValue(of(stubMovies))

      const masterlistService = new MasterlistService(spyHttpClient)

      let movies
      masterlistService.getAll()
        .subscribe(value => movies = value)

      expect(movies.length).toBe(4)
      expect(movies[0].id).toBe(1)
      expect(movies[0].name).toBe('movie 1')
    }))
  })
})
