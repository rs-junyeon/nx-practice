import { useEffect, useState } from 'react';
import { createApiClient } from '@org/api-client';

const api = createApiClient();

export function App() {
  const [message, setMessage] = useState<string>();

  useEffect(() => {
    api
      .GET('/api/hello', { params: { query: { name: 'react-web' } } })
      .then(({ data }) => setMessage(data?.message))
      .catch(() => setMessage(undefined));
  }, []);

  return (
    <>
      <h1>react-web</h1>
      <p>{message ?? 'spring-server 응답 대기 중...'}</p>
    </>
  );
}

export default App;
