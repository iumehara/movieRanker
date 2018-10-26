import {ComponentFixture, TestBed} from '@angular/core/testing'

import {WatchedlistComponent} from './watchedlist.component'

describe('WatchedlistComponent', () => {
  let fixture: ComponentFixture<WatchedlistComponent>

  beforeEach(() => {
    TestBed.configureTestingModule({declarations: [ WatchedlistComponent ]})
    fixture = TestBed.createComponent(WatchedlistComponent)
  })

  it('displays movie name with remove button', () => {
    const component = fixture.componentInstance
    component.movies = [{id: 1, name: 'test movie'}]

    fixture.detectChanges()

    const listText = fixture.nativeElement.querySelector('.list').textContent
    expect(listText).toContain('test movie')
    expect(listText).toContain('Remove')
  })
})
