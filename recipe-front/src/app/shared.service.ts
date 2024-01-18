import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SharedService {
  private userIdSubject = new BehaviorSubject<string | null>(null);
  currentUserId = this.userIdSubject.asObservable();

  setUserId(id: string) {
    this.userIdSubject.next(id);
  }

  getUserId(): string | null {
    return this.userIdSubject.value;
  }
}
