import {Component, inject} from '@angular/core';
import {BackendService} from "../../service/backend.service";
import {Message} from "../../model/message.model";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-message-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './message-list.component.html',
  styleUrl: './message-list.component.scss'
})
export class MessageListComponent {

  private _backendService:BackendService = inject(BackendService);
  protected messages:Message[];

  constructor() {
    this._backendService.getMessages()
      .subscribe(
        {
          next: (message: Message[]) => this.messages = message,
          error: (error) => console.error(error)
        }
      );
  }

}
