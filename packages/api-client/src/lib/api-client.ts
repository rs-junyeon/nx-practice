import createClient from 'openapi-fetch';
import type { paths } from '../generated/schema.js';

// 생성된 타입은 spring-server의 OpenAPI 명세에서 만들어진다 (nx run @org/api-client:generate)
export type { components, paths } from '../generated/schema.js';

export function createApiClient(baseUrl = '') {
  return createClient<paths>({ baseUrl });
}
