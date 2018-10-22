import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'

import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { ListManagerComponent } from './list-manager/list-manager.component'

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    ListManagerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
