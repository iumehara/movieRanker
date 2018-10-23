import { BrowserModule } from '@angular/platform-browser'
import { NgModule } from '@angular/core'

import { AppComponent } from './app.component'
import { MasterlistComponent } from './masterlist/masterlist.component'
import { ListManagerComponent } from './list-manager/list-manager.component'
import { WishlistComponent } from './wishlist/wishlist.component';
import { WatchedlistComponent } from './watchedlist/watchedlist.component'

@NgModule({
  declarations: [
    AppComponent,
    MasterlistComponent,
    ListManagerComponent,
    WishlistComponent,
    WatchedlistComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
