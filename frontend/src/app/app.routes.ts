import {Routes} from '@angular/router';
import {MessageListComponent} from "./components/message-list/message-list.component";
import {MessageCreateComponent} from "./components/message-create/message-create.component";
import {MessageDetailComponent} from "./components/message-detail/message-detail.component";

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'messages',
    pathMatch: 'full'
  },
  {
    path: 'messages',
    component: MessageListComponent
  },
  {
    path: 'messages/create',
    component: MessageCreateComponent
  },
  {
    path: 'messages/:id',
    component: MessageDetailComponent
  }
];
