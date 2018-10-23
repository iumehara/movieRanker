import {MasterlistService} from './masterlist.service'
import {fakeAsync} from '@angular/core/testing'

describe('MasterlistService', () => {
  it('has multiple movies by default', fakeAsync(() => {
    const masterlistService = new MasterlistService()

    let movies
    masterlistService.getAll()
      .subscribe(value => movies = value)

    expect(movies.length).toBeGreaterThan(0)
  }))
})
